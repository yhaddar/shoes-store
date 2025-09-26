import {HeroComponent} from "@/app/(Pages)/home/heroComponent/heroComponent";
import {Brands} from "@/app/(Pages)/home/brands/brands";

export const HomeComponent = () => {

    return (
        <>
            <div>
                <HeroComponent />
            </div>

            <div className={"my-18"}>
                <Brands />
            </div>
        </>
    )
}