import {CartType} from "@/app/Components/Card/cart.type";
import Image from "next/image";
import {BACKGROUND_COLORS} from "@/app/utils/colors";
import {NUNITO} from "@/app/utils/fonts";

export const Card = ({ items }: CartType[] | any) => {
    return (
        <>
            {
                items && items?.map((item: CartType, index: number) => {
                    return (
                        <div key={index} className={"flex flex-col items-center gap-2"}>
                            <div
                                className={"w-[100px] h-[100px] rounded-full flex justify-center items-center"}
                                style={{ backgroundColor: BACKGROUND_COLORS.COLOR_PRIMARY_2 }}
                            >
                                <Image src={`${item.image}`} alt={`${item.name}`} width={65} height={65} />
                            </div>
                            <h2 className={`text-[20px] capitalize ${NUNITO.className} font-bold`}>{item.name}</h2>
                        </div>
                    )
                })
            }
        </>
    )
}