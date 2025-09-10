"use client"

import {useDispatch, useSelector} from "react-redux";
import {BrandsComponent} from "@/app/(Pages)/home/component/brands.component";
import { DescriptionComponent } from "./component/description.component";
import { TextComponent } from "./component/text.component";
import {DiscountComponent} from "@/app/(Pages)/home/component/discount.component";
import {InfoComponent} from "@/app/(Pages)/home/component/Info.component";
import {brandWithShoes, initialStateType} from "@/app/features/home/Home.type";
import {ImageComponent} from "@/app/(Pages)/home/component/image.component";
import {useEffect, useState} from "react";
import {heroComponentThunk} from "@/app/features/home/Home.thunk";
import {AppDispatch} from "@/app/store";
import Loading from "@/app/loading";

export const HomeComponent = () => {

    const { data, loading } = useSelector((state: { heroComponent: initialStateType }): initialStateType => state?.heroComponent);

    console.log(data)
    const brands: string[] | undefined = data?.map((b: brandWithShoes): string => b?.brand);
    let [index, setIndex] = useState<number>(0);

    const dispatch = useDispatch<AppDispatch>();

    useEffect(() => {
        dispatch(heroComponentThunk())
    }, []);

    return (
        <>
            {
                loading ? <Loading /> : <section className={"h-[93vh] pt-[66px]"}>

                    <div className={"w-full h-[93vh] flex justify-between items-stretch"}>

                        <div className={"bg--500 w-[25%] flex justify-around flex-col"}>

                            <BrandsComponent brands={brands} selected={index} color={data && data[index]?.shoes?.color}/>
                            <DescriptionComponent
                                description={data && data[index]?.shoes?.description}
                                release_date={data && data[index]?.shoes?.release_date}
                                color={data && data[index]?.shoes?.color}
                            />

                        </div>

                        <div className={"w-1/2 mt-[60px]"}>

                            <section className={"w-[100%] mx-auto relative"}>
                                <TextComponent color={data && data[index]?.shoes?.color} />


                                <div className={"flex -rotate-10 justify-center absolute top-[100px] right-0 left-0 -z-10"}>
                                    <ImageComponent image={data && data[index]?.shoes?.image} />
                                </div>
                            </section>

                        </div>


                        <div className={"w-[25%] flex justify-center flex-col"}>
                            <div className={"flex flex-col h-[70%] justify-between"}>
                                <DiscountComponent discount={data && data[index]?.shoes?.discount} color={data && data[index]?.shoes?.color} />
                                <InfoComponent
                                    name={data && data[index]?.shoes?.name}
                                    stock={data && data[index]?.shoes?.stock}
                                    price={data && data[index]?.shoes?.price}
                                    otherShoes={data && data[index]?.shoes?.shoesSecondary}/>
                            </div>
                        </div>


                    </div>

                </section>
            }
        </>
    )
}