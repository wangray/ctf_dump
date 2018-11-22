import { Type, E } from "./lambda";

export const toString = Symbol("toString");

function getCleanObject(): { [key: string]: any } {
	let obj = {};
	for (let prop of Object.getOwnPropertyNames((obj as any).__proto__)) {
		(obj as any)[prop] = undefined;
	}
	(obj as any).__proto__ = undefined;
	return obj;
}

function emulate(e: E, sigma: { [key: string]: any }): any {
	switch(e.kind) {
		case "ALIAS": {
			return emulate(e.value, sigma);
		}
		case "UNIT": {
			return null;
		}
		case "NUMBER": {
			return e.value;
		}
		case "TYPED_IDENT":
		case "UNTYPED_IDENT": {
			return sigma[e.value];
		}
		case "LAMBDA": {
			let lambda: any =  function (param: any) {
				return emulate(e.value, { ...sigma, [e.binding.value]: param });
			}
			lambda[toString] = () => "[lambda]";
			return lambda;
		}
		case "TYPE_LAMBDA": {
			let lambda: any = function () {
				return emulate(e.value, sigma);
			}
			lambda[toString] = () => "[type_lambda]";
			return lambda;
		}
		case "FIXED": {
			let f:any = function (param: any) {
				return emulate(
					e.value,
					{ ...sigma, [e.binding.value]: param, [e.fn]: f });
			}
			f[toString] = () => "[fix]"
			return f;
		}
		case "CALL": {
			let arg = emulate(e.subst, sigma);
			let fn = emulate(e.value, sigma);
			return fn(arg);
		}
		case "TYPE_CALL": {
			let fn = emulate(e.value, sigma);
			return fn();
		}
		case "FOLD": {
			return emulate(e.value, sigma);
		}
		case "UNFOLD": {
			return emulate(e.value, sigma);
		}
		case "TUPLE": {
			let obj: any = getCleanObject();
			for (let i = 0; i < e.value.length; i++) {
				let { label, value } = e.value[i];
				obj[label] = emulate(value, sigma);
			}
			obj[toString] = () => "{ tuple }"
			return obj;
		}
		case "SUM": {
			let obj: any = getCleanObject();
			obj[e.sumLabel] = emulate(e.value, sigma);
			obj[toString] = () => "< sum >"
			return obj;
		}
		case "EXTRACT": {
			let value = emulate(e.value, sigma);
			return value[e.productLabel];
		}
		case "CASE": {
			let binding = emulate(e.binding, sigma);
			for (let entry of e.value) {
				if (binding[entry.label] !== undefined) {
					let substVal = binding[entry.label];
					return emulate(entry.value, 
						{ ...sigma, [entry.binding.value]: substVal });
				}
			}
			throw new Error(`Failed to find case ${Object.keys(binding)}`);
		}
		case "PLUS": {
			let e1 = emulate(e.value[0], sigma);
			let e2 = emulate(e.value[1], sigma);
			return e1 + e2;
		}
		case "TIMES": {
			let e1 = emulate(e.value[0], sigma);
			let e2 = emulate(e.value[1], sigma);
			return e1 * e2;
		}
	}
}

export function resToString(r: any): string {
	if (typeof r === "object" || typeof r === "function") {
		return r[toString]();
	} else {
		return r.toString();
	}
}

export default function emulator(e: E): any {
	return emulate(e, getCleanObject());
}