import { useParams } from "react-router";
import { getTenant, type PublicTenant } from "../api/tenant";
import { useEffect, useState } from "react";

type Status = 'loading' | 'not-found' | 'error' | 'success';

export default function StorePage(){
    
    const {slug} = useParams();

    const [tenant, setTenant] = useState<PublicTenant | null>(null);
    const [status, setStatus] = useState<Status>('loading');

    useEffect( () => {
            if(!slug) return;

            getTenant(slug)
                .then((data) => {
                    setTenant(data);
                    setStatus('success');
                })
                .catch((error) => {
                    setStatus(
                        error.message === 'STORE_NOT_FOUND' ? 'not-found' : 'error'
                    )
                })
        }, [slug]
    )

    return (
        <>
            {status === 'not-found' && <h1>Store not found...</h1>}
            {status === 'error' && <h1>Request failed...</h1>}
            {status === 'loading' && <h1>Loading...</h1>}
            {status === 'success' &&
                <>
                    <h1>{tenant?.name}</h1>
                    <h2>{tenant?.phoneNumber}</h2>
                    <h2>{tenant?.address}</h2>
                </>
            }
        </>
    );
}