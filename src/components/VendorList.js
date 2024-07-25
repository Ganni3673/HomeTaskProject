import React, { useEffect, useState } from 'react';
import axios from 'axios';

function VendorList() {
    const [vendors, setVendors] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8080/api/vendor/getAllVendor')
            .then(response => {
                setVendors(response.data);
            });
    }, []);

    return (
        <div>
            <h2>Vendors</h2>
            <ul>
                {vendors.map(vendor => (
                    <li key={vendor.email}>
                        {vendor.name} - {vendor.email} - {vendor.upi}
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default VendorList;
