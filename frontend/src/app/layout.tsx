"use client"
import "./globals.css";
import {Header} from "@/app/Components/Header/header";
import {Provider} from "react-redux";
import {store} from "@/app/store";

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="en">
      <body
      >
          <Provider  store={store}>
            <Header />
            {children}
          </Provider>
      </body>
    </html>
  );
}
