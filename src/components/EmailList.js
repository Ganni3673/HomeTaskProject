import React, { useEffect, useState } from 'react';
import axios from 'axios';

function EmailList() {
    const [emails, setEmails] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8080/api/email/getAllEmail')
            .then(response => {
                setEmails(response.data);
            });
    }, []);

    return (
        <div>
            <h2>Sent Emails</h2>
            <ul>
                {emails.map((email, index) => (
                    <li key={index}>
                        To: {email.recipient}, Subject: {email.subject}, Body: {email.body}
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default EmailList;
