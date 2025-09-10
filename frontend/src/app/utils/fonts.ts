import {
    Architects_Daughter,
    Fugaz_One,
    Kanit,
    Lexend_Giga,
    Luckiest_Guy,
    Nunito,
    PT_Sans,
} from "next/font/google";
import {NextFont} from "next/dist/compiled/@next/font";

const PT_SANS: NextFont = PT_Sans({
    subsets: ['latin'],
    weight: "400",
    fallback: ["sans-serif"]
});

const KANIT: NextFont = Kanit({
    subsets: ['latin'],
    weight: ['400'],
    style: 'italic'
});

const FUGAZ_ONE: NextFont = Fugaz_One({
   subsets: ['latin'],
   weight: ['400'],
});

const NUNITO: NextFont = Nunito({
    subsets: ['latin'],
    weight: ['500', '300', '800']
});

const LUCKIEST_GUY: NextFont = Luckiest_Guy({
    subsets: ['latin'],
    weight: ['400']
});

const LEXEND_GIGA: NextFont = Lexend_Giga({
    weight: ['400', '800'],
    subsets: ['latin'],
    style: ['normal']
})

export { PT_SANS, KANIT, FUGAZ_ONE, NUNITO, LUCKIEST_GUY, LEXEND_GIGA };