import React, { useEffect, useState } from 'react';
import axios from 'axios';

function EmpList() {
    const [employees, setEmployees] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8080/api/emp/getemployee')
            .then(response => {
                setEmployees(response.data);
            })
            .catch(error => {
                console.error('There was an error fetching the employees!', error);
            });
    }, []);

    return (
        <div>
            <h2>Employees</h2>
            <ul>
                {employees.map(employee => (
                    <li key={employee.email}>
                        {employee.name} - {employee.designation} - {employee.ctc} - {employee.email}
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default EmpList;
