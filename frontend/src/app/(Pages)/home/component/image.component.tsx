import Image from "next/image";

interface propsInterface {
    image: string | null | undefined;
}

export const ImageComponent = ({ image }: propsInterface) => {
    return (
        <>
            <div className="flex justify-start items-start">
                {
                    image &&  <Image
                        width={740}
                        height={500}
                        src={image}
                        alt=""
                        className={"h-auto"}
                    />
                }
            </div>
        </>
    )
}