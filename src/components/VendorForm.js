import React, { useState } from 'react';
import axios from 'axios';

function VendorForm() {
    const [vendor, setVendor] = useState({
        name: '',
        email: '',
        upi: ''
    });

    const handleChange = (e) => {
        setVendor({
            ...vendor,
            [e.target.name]: e.target.value
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        axios.post('http://localhost:8080/api/vendor/vendor', vendor)

            .then(response => {
                alert('Vendor added successfully!');
                setVendor({
                    name: '',
                    email: '',
                    upi: ''
                });
            });
    };

    return (
        <form onSubmit={handleSubmit}>
            <input type="text" name="name" value={vendor.name} onChange={handleChange} placeholder="Name" required />
            <input type="email" name="email" value={vendor.email} onChange={handleChange} placeholder="Email" required />
            <input type="text" name="upi" value={vendor.upi} onChange={handleChange} placeholder="UPI" required />
            <button type="submit">Add Vendor</button>
        </form>
    );
}

export default VendorForm;
