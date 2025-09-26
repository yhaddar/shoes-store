import {NUNITO} from "@/app/utils/fonts";
import {BORDER_COLORS, FONT_COLORS} from "@/app/utils/colors";
import Image from "next/image";
import {shoesSecondaryResponse} from "@/app/features/home/Home.type";

interface propsInterface {
    name: string | null | undefined;
    stock: number | null | undefined;
    price: number | null | undefined;
    otherShoes: shoesSecondaryResponse[] | null | undefined;
}

export const InfoComponent = ({ name, stock, price, otherShoes }: propsInterface) => {

    return (
        <>
            <div className={"mx-3"}>
                { stock == 0 || stock == null ?
                    <p className={`${NUNITO.className} text-lg font-extrabold mb-1`} style={{ color: FONT_COLORS.COLOR_DANGER }}>coming soon</p>
                    : stock <= 10 ?
                    <p className={`${NUNITO.className} text-lg font-extrabold mb-1`} style={{ color: FONT_COLORS.COLOR_DANGER }}>limited stock</p> : null
                }
                <h1 className={`${NUNITO.className} text-2xl capitalize font-extrabold`}>{name}</h1>
                <p className={`${NUNITO.className} text-lg font-semibold text-justify mt-2`}
                   style={{color: FONT_COLORS.COLOR_PRIMARY_4}}>{price} DH</p>

                    <div className={"flex gap-8 items-center my-4"}>

                        {
                            otherShoes?.map((s: shoesSecondaryResponse, index: number) => (
                                <div className={"w-[60px] h-[60px] flex items-center justify-center rounded-full border"} style={{ borderColor: BORDER_COLORS.COLOR_PRIMARY_2 }} key={index}>
                                    <Image width={500} height={500} className={"w-full h-full p-1 -rotate-26"} src={s?.image} alt={""} />
                                </div>
                            ))
                        }

                    </div>

            </div>
        </>
    )
}