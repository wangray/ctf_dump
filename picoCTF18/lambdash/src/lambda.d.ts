export type Label = string;

export type CaseEntry =
	| { label: Label, binding: Ident, value: E }
	;

export type TupleEntry =
	| { label: Label, value: E }
	;

export type Ident =
    | { kind: "TYPED_IDENT",   value: string, type: Type }
    | { kind: "UNTYPED_IDENT", value: string }
    ;

export type E = 
	| { kind: "ALIAS",       value: E, ident: string, type: Type }
    | { kind: "CALL",        value: E, subst: E }
	| { kind: "TYPE_CALL",   value: E, subst: Type }
    | { kind: "FOLD",        value: E, type: Type }
    | { kind: "UNFOLD",      value: E }
    | { kind: "LAMBDA",      value: E, binding: Ident }
    | { kind: "TYPE_LAMBDA", value: E, binding: string }
    | { kind: "FIXED",       value: E, binding: Ident, fn: string, returnType: Type }
    | { kind: "TUPLE",       value: TupleEntry[] }
    | { kind: "SUM",         value: E, sumLabel: Label, type: Type }
    | { kind: "EXTRACT",     value: E, productLabel: Label }
    | { kind: "CASE",        value: CaseEntry[], binding: E }
    | { kind: "PLUS",        value: [E, E] }
    | { kind: "TIMES",       value: [E, E] }
    | { kind: "NUMBER",      value: number }
    | { kind: "UNIT" }
    | Ident
    ;

export type LabelType =
	| { label: Label, value: Type }
	;

export type Type =
    | { kind: "UNIT" }
    | { kind: "INT" }
    | { kind: "TYPE_VAR", value: string }
    | { kind: "SUM",      value: LabelType[] }
    | { kind: "PRODUCT",  value: LabelType[] }
    | { kind: "ARROW",    value: [Type, Type] }
    | { kind: "REC",      value: Type, binding: string }
    | { kind: "NEEDS_CONSTRAINT", binding: string, type: Type }
    ;

export function parse(input: string): E