import * as fs from "mz/fs";
import * as lambda from "./lambda";
import typechecker from "./typechecker";
import emulator from "./emulator";

if (process.argv.length < 3) {
	console.log(`node dist/index.js <file>`);
	process.exit(1);
}

async function run() {
	let file = await fs.readFile(process.argv[2]);
	let ast = lambda.parse(file.toString());
	console.log(typechecker(ast));
	console.log(emulator(ast));
}

run()