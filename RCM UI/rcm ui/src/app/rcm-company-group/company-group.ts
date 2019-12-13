export class CompanyGroup{
    _id:string;
    group_id:string;
    group_name: string;
    is_eligibility_check_required: boolean;
    is_electronic_claim: boolean;
    maximum_allowed_discount: number;
    is_active: boolean;
    effective_date: Date;
    approval_limit_days: number;
    email_address: string;
    phone_number: string;
    address: string;
    contact_person: string;
    contact_person_mobile_number:string;
    contact_person_email_address:string;
}