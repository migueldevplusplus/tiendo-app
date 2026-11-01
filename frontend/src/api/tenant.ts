const API_URL = import.meta.env.VITE_API_URL;

export type PublicTenant = {
    name: string,
    phoneNumber: string,
    slug: string,
    address: string | null,
    logoUrl: string | null,
};

export async function getTenant(slug: string): Promise<PublicTenant>{
    const response = await fetch(`${API_URL}/api/v1/public/tenants/${slug}`);

    if(response.status === 404){
        throw new Error("STORE_NOT_FOUND");
    }
    if(!response.ok){
        throw new Error("REQUEST_FAILED");
    }

    return response.json();
}