import { fonction } from 'src/models/fonction';

export class User {
    id: number;
    email : string;
    username :string;
    password: string;
    fullname: string;
    matricule: string;
    dateIntegration : Date;
    fonction : fonction;
}