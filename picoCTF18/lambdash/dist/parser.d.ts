declare namespace ParseTree {
    type Label = string;
    type CaseEntry = {
        label: Label;
        binding: Ident;
        value: E;
    };
    type TupleEntry = {
        label: Label;
        value: E;
    };
    type Ident = {
        label: "TYPED";
        type: Type;
        value: string;
    } | {
        label: "UNTYPED";
        value: string;
    };
    type E = {
        label: "CALL";
        value: E;
        subst: E;
    } | {
        label: "TYPE_CALL";
        value: E;
        subst: Type;
    } | {
        label: "LAMBDA";
        value: Ident;
        binding: E;
    } | {
        label: "TYPE_LAMBDA";
        value: E;
        binding: string;
    } | {
        label: "CASE";
        value: CaseEntry[];
        binding: Ident;
    } | {
        label: "TUPLE";
        value: TupleEntry[];
    } | {
        label: "EXTRACT";
        value: E;
        productLabel: Label;
    } | {
        label: "NUMBER";
        value: number;
    } | {
        label: "SUM";
        value: E;
        sumLabel: Label;
    } | {
        label: "PLUS";
        value: [E, E];
    } | {
        label: "TIMES";
        value: [E, E];
    };
    type SumType = {
        label: "SUM";
        sumLabel: Label;
        value: Type;
    };
    type ProductType = {
        label: "PRODUCT";
        sumLabel: Label;
        value: Type;
    };
    type Type = {
        label: "INT";
    } | {
        label: "TYPE_VAR";
        value: string;
    } | {
        label: "SUM";
        value: SumType[];
    } | {
        label: "PRODUCT";
        value: ProductType[];
    } | {
        label: "ARROW";
        value: [Type, Type];
    };
}
export default function parse(input: string): ParseTree.E;
export {};
