"use client";
import {useEffect, useMemo, useState} from "react";
import {Caching} from "@/app/utils/caching";
import {useDispatch, useSelector} from "react-redux";
import {initialStateType} from "@/app/features/home/Home.type";
import {AppDispatch} from "@/app/store";
import {BrandsThunk} from "@/app/features/brands/Brands.thunk";
import {Card} from "@/app/Components/Card/card";
import {brandInerface} from "@/app/features/brands/Brands.type";

export const Brands = () => {

    const dispatch = useDispatch<AppDispatch>();
    const cache = new Caching("brands");
    const [brands, setBrands] = useState<brandInerface[]>([])

    useEffect(() => {
        const fetchAndCache = async () => {

            if(await cache.size() > 0){

                const data = await cache.index();
                setBrands(data[0]?.data);

            }else {
                const result = await dispatch(BrandsThunk());

                await cache.store(result.payload);
            }


        };

        fetchAndCache();
    }, [dispatch]);

    return (
        <>
            <div className={"container mx-auto"}>
                <div className={"grid grid-flow-col grid-rows-2 gap-10"}>
                    <Card items={brands} />
                </div>
            </div>
        </>
    )
}