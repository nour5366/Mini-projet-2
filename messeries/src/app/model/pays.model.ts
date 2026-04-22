export class Pays {
    codePays! : number;
    nomPays! : string;
    continent! : string;
}

export class PaysWrapper {
    _embedded!: { pays: Pays[] };
}
