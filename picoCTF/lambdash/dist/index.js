"use strict";
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : new P(function (resolve) { resolve(result.value); }).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
Object.defineProperty(exports, "__esModule", { value: true });
const fs = require("mz/fs");
const lambda = require("./lambda");
const typechecker_1 = require("./typechecker");
const emulator_1 = require("./emulator");
if (process.argv.length < 3) {
    console.log(`node dist/index.js <file>`);
    process.exit(1);
}
function run() {
    return __awaiter(this, void 0, void 0, function* () {
        let file = yield fs.readFile(process.argv[2]);
        let ast = lambda.parse(file.toString());
        console.log(typechecker_1.default(ast));
        console.log(emulator_1.default(ast));
    });
}
run();
//# sourceMappingURL=index.js.map