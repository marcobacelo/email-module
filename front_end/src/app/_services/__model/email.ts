export class Email {
    id: number;
    subject: string;
    address: string;
    body: string;

    constructor(email: any){
        this.id = email.id;
        this.subject = email.subject;
        this.address = email.address;
        this.body = email.body;
    }
}
