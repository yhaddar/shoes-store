import {FUGAZ_ONE} from "@/app/utils/fonts";
import {FONT_COLORS} from "@/app/utils/colors";

interface propsInterface {
    brands: string[] | any;
    selected: number;
    color: string | any
}
export const BrandsComponent = ({ brands, selected, color }: any | string[]) => {

    return (
        <>
            <div className={"mt-10"}>
                <ul className={"flex flex-col gap-5 items-center"}>
                    {
                        brands?.map((brand: string, index: number) => {
                            return (
                                <li key={index}>
                                    <p className={`text-[34px] font-normal uppercase text-black ${FUGAZ_ONE.className} italic`}
                                       style={{
                                           color: selected === index ? color : FONT_COLORS.COLOR_PRIMARY_3,
                                           transform: selected === index ? 'scale(1.22)' : 'scale(1)' }}
                                    >{brand}</p>
                                </li>
                            )
                        })
                    }
                </ul>
            </div>
        </>
    )
}