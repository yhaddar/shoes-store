import moment from "moment";

export const FormatDate = (d: Date): string => {
    const date = new Date();
    return moment(date).format("YYYY") ;


}