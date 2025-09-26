import {LEXEND_GIGA, NUNITO} from "@/app/utils/fonts";
import {FONT_COLORS} from "@/app/utils/colors";
import {GrValidate} from "react-icons/gr";
import {FormatDate} from "@/app/utils/date";

interface propsInterface {
    description: string | any;
    release_date: string | any;
    color: string | any;
}

export const DescriptionComponent = ({ description, release_date, color }: propsInterface) => {
    return (
        <>
            <div className={"mx-3"}>
                <h1 className={`${NUNITO.className} text-xl capitalize text- font-bold`}>unbeatable performance</h1>
                <p className={`${NUNITO.className} text-lg text-justify font-medium mt-3`}
                   style={{color: FONT_COLORS.COLOR_PRIMARY_4}}>{description?.slice(0, 200).concat("...")} </p>
                <h2 className={`flex gap-2 items-center mt-5 justify-end font-extrabold ${LEXEND_GIGA.className}`}>
                    <span className={"text-3xl"}><GrValidate/></span>
                    <span className={"text-7xl"} style={{ color: color }}>{release_date}</span>
                </h2>
            </div>
        </>
    )
}