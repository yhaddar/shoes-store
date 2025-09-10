import {KANIT, PT_SANS} from "@/app/utils/fonts";
import {BACKGROUND_COLORS, BORDER_COLORS, FONT_COLORS} from "@/app/utils/colors";
import Link from "next/link";
import {Icons} from "@/app/Components/Header/header.type";
import {CiShoppingCart, CiUser} from "react-icons/ci";

export const Header = () => {

    const pages: string[] = ["home", "about", "products", "contact"];
    const icons: Icons[] = [
        {
            icon: CiShoppingCart,
            url: "/cart"
        },
        {
            icon: CiUser,
            url: "/profile"
        }
    ]

    return (
        <>
            <section className={"w-full border-b-2 fixed z-10"} style={{ borderBottomColor: BORDER_COLORS.COLOR_PRIMARY_1, background: BACKGROUND_COLORS.COLOR_PRIMARY_1 }}>
                <div className={"container mx-auto flex items-center justify-between py-4"}>

                    <div className={"w-1/4"}>
                        <h1 className={`${KANIT.className} text-xl italic`} style={{ color: FONT_COLORS.COLOR_PRIMARY_2 }}>OnlySneaks</h1>

                    </div>

                    <div className={"w-1/2"}>

                        <ul className={"flex items-center justify-evenly"}>
                            {
                                pages?.map((page: string, index: number) => {
                                    return (
                                        <li key={index}>
                                            <Link href={`${page == "home" ? '/' : page}`} className={`text-[20px] capitalize ${PT_SANS.className}`} style={{ color: FONT_COLORS.COLOR_PRIMARY_1 }}>{page}</Link>
                                        </li>
                                    )
                                })
                            }
                        </ul>

                    </div>

                    <div className={"w-1/4 flex justify-end items-center gap-2"}>

                        {
                            icons?.map((icon: Icons, index: number) => {
                                const Icon = icon.icon;
                                return (
                                    <div key={index}>
                                       <Link href={icon.url}>
                                           <Icon  className={"text-3xl"} />
                                       </Link>
                                    </div>
                                )
                            })
                        }

                    </div>

                </div>
            </section>
        </>
    )
}