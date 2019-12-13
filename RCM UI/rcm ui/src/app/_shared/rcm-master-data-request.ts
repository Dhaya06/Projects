export class RCMasterDataRequest<T>{
    type: string;
    body : T;

    constructor(type: string, body: T) {
        this.type = type;
        this.body = body;
     }
}