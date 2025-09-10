import {combineReducers} from "redux";
import {HeroComponentStore} from "@/app/features/home/Home.slice";

export const rootReducer = combineReducers({
   heroComponent: HeroComponentStore.reducer,
});