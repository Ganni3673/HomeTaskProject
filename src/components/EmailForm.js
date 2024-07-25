import React, { useState, useEffect } from 'react';
import axios from 'axios';

function EmailForm() {
    const [vendorEmails, setVendorEmails] = useState([]);
    const [vendors, setVendors] = useState([]);

    useEffect(() => {
        axios.get('/vendors')
            .then(response => {
                setVendors(response.data);
            });
    }, []);

    const handleSubmit = (e) => {
        e.preventDefault();
        axios.post('http://localhost:8080/api/email/send', vendorEmails)
            .then(response => {
                alert('Emails sent successfully!');
                setVendorEmails([]);
            });
    };

    const handleChange = (e) => {
        const value = Array.from(
            e.target.selectedOptions,
            (option) => option.value
        );
        setVendorEmails(value);
    };

    return (
        <form onSubmit={handleSubmit}>
            <select multiple value={vendorEmails} onChange={handleChange}>
                {vendors.map(vendor => (
                    <option key={vendor.email} value={vendor.email}>
                        {vendor.name} ({vendor.email})
                    </option>
                ))}
            </select>
            <button type="submit">Send Emails</button>
        </form>
    );
}

export default EmailForm;
