class DateHelper {

    date

    constructor(date) {
        
        this.date = date; 

    }

    static dateToFormattedString(date) {

        if (typeof date != Date && typeof date != date) {
            throw new Error(`Type ${typeof date} is not valid for DateHelper. Try passing String or Date;`);
        }        

        return `${date.getDay()}/${date.getMonth() + 1}/${date.getFullYear()}`;
    }

    static stringToFormattedString(date) {

        if (!date.includes("-")) {
            throw new Error("Date format is not correct. Try passing string like 'dd/mm/yyyy';")
        }

        date = date.split("-");
        return `${date[2]}/${date[1]}/${date[0]}`;
    }

    static stringToInternationalString(date) {
        
        if (!date.includes("/")) {
            throw new Error("Date format is not correct. Try passing string like 'dd/mm/yyyy';")
        }

        date = date.split("/");
        return `${date[2]}-${date[1]}-${date[0]}`;

    }


   
}
