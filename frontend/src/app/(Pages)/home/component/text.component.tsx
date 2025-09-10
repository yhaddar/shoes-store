import {LUCKIEST_GUY} from "@/app/utils/fonts";

export const TextComponent = ({ color }: string | any) => {


    return (
        <>
            <main>
                <div className={"w-[100%] mx-auto"}>
                    <h1 className={`${LUCKIEST_GUY.className} z-10 text-[100px] text-center`} style={{ color: color }}>Elevate Your Style, One Step at a Time</h1>
                </div>
            </main>
        </>
    )
}