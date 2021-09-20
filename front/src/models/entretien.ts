
import { User } from 'src/models/user';
import { Campagne } from 'src/models/campagne';
export class Entretien {
    id: number;
    date:Date;
    formations:string;
    certifications:string;
    axes:string;
    points:string;
    projet:string;
    status:string;
    user:User;
    compagne:Campagne;
    remarque:string;
}