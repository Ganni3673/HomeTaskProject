import React, { useState } from 'react';
import axios from 'axios';

function EmpForm() {
    const [employee, setEmployee] = useState({
        name: '',
        designation: '',
        ctc: '',
        email: ''
    });

    const handleChange = (e) => {
        setEmployee({
            ...employee,
            [e.target.name]: e.target.value
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        axios.post('http://localhost:8080/api/emp/empo', employee)
            .then(response => {
                alert('Employee added successfully!');
                setEmployee({
                    name: '',
                    designation: '',
                    ctc: '',
                    email: ''
                });
            })
            .catch(error => {
                console.error('There was an error adding the employee!', error);
            });
    };

    return (
        <form onSubmit={handleSubmit}>
            <input type="text" name="name" value={employee.name} onChange={handleChange} placeholder="Name" required />
            <input type="text" name="designation" value={employee.designation} onChange={handleChange} placeholder="Designation" required />
            <input type="number" name="ctc" value={employee.ctc} onChange={handleChange} placeholder="CTC" required />
            <input type="email" name="email" value={employee.email} onChange={handleChange} placeholder="Email" required />
            <button type="submit">Add Employee</button>
        </form>
    );
}

export default EmpForm;
