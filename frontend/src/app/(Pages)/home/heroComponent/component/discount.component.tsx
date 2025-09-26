import {LEXEND_GIGA, NUNITO} from "@/app/utils/fonts";
import {FONT_COLORS} from "@/app/utils/colors";
import {CiDiscount1} from "react-icons/ci";

interface propsInterface {
    discount?: number | null | undefined;
    color: string | any
}
export const DiscountComponent = ({ discount, color }: propsInterface) => {
    return (
        <>
            <div className={""}>
                <h1 className={`${NUNITO.className} text-5xl capitalize text-center font-bold italic`}>Discount</h1>
                <h2 className={`flex gap-2 items-center mt-5 justify-end font-extrabold ${LEXEND_GIGA.className}`}>
                    <span className={"text-3xl"}><CiDiscount1/></span>
                    <span className={"text-7xl"} style={{ color: color }}>{discount?.toString().concat("%")}</span>
                </h2>
            </div>
        </>
    )
}