import type { NextConfig } from "next";

const nextConfig: NextConfig = {
  /* config options here */
  images: {
    remotePatterns: [
      {
        protocol: "http",
        port: "8080",
        hostname: "localhost",
        pathname: "/**"
      }
    ]
  },
  devIndicators: false
};

export default nextConfig;
