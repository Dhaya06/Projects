export class PayerProfile{

    _id:string;
    profile_id: string;
    company_id: string;
    profile_name: string;
    group_name: string; 
    category: string;
    submission_format: string;
    submission_template: string;
    submission_time_period: number;
    resubmission_time_period: number;
    is_cover_letter_needed: boolean;
    is_printouts_needed: boolean;
    is_portal_needed: boolean;
    submission_url: string;
    submission_date_of_month: number;
    payment_method: string;
    payment_time_period: number;
}

