import * as express from "express";
import { Provider } from "nconf";
import { fs } from "mz";
import * as path from "path";
import * as parser from "body-parser";
import { parse, E, Type } from "./lambda";
import typecheck, { typeToString } from "./typechecker";
import emulator, { resToString } from "./emulator";
import * as vm2 from "vm2";

const nconf =
	(new Provider())
	.argv()
	.env()
	.defaults({
		PORT: "4001",
		FLAG: "fakeCTF{You didnt think it would be this easy did you? Now go find a real flag}"
	})

async function start() {
	const app = express();

	app.use(parser.urlencoded());
	app.use("/scripts", express.static(path.join(__dirname, "..", "client", "scripts")))
	app.use("/styles", express.static(path.join(__dirname, "..", "client", "styles")))

	app.get("/", async (req, res) => {
		console.log(req.query);
		let { page } = req.query;
		if (page && page.indexOf("..") >= 0) {
			page = undefined;
		}
		page = page || "client/pages/intro.html";
		let fileData = await fs.readFile(path.join(__dirname, "..", "client/index.html"));
		let pageData = await fs.readFile(path.join(__dirname, "..", page));
		let rendered = fileData.toString().replace(/\{server-body\}/g, pageData.toString());
		res.send(rendered);
	})

	app.post("/run", (req, res) => {
		let code = req.body.code;
		let ast: E; 
		try {
			ast = parse(code);
		} catch (e) {
			res.send(`Error -- code did not parse<br>${e.toString()}`);
			return;
		}
		let type: Type;
		try {
			type = typecheck(ast);
		} catch (e) {
			res.send(`Error -- code did not typecheck<br>${e.toString()}`);
			return;
		}
		let vm = new vm2.NodeVM({
			timeout: 1000,
			sandbox: {
				ast,
				hidden: {
					getFlag: ((f: string) => ((x: string) => {
						if (x === "if you can get this you deserve the flag -> abcd1234!@#$%^&*()'") {
							return f;
						}
						return "Bad! " + x;
					}))(process.env.FLAG)
				},
			},
			require: {
				context: "sandbox",
				external: ["./emulator", "immutable"],
				root: __dirname,
			},
		});
		try {
			let result = vm.run(new vm2.VMScript(`
				let emulator = require("${__dirname}/emulator");
				module.exports = emulator.resToString(emulator.default(ast));
			`));
			console.log(result);
			res.send(`Result:<br>${result}:${typeToString(type)}`);
		} catch (e) {
			console.log("Wut", e.stack);
			res.send(`Error -- failed to execute<br>${e}`);
		}

	})

	app.listen(nconf.get("PORT"));
}

start();
