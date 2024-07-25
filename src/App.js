import React from 'react';
import EmpForm from './components/EmpForm';

import VendorForm from './components/VendorForm';
import EmailForm from './components/EmailForm';
import EmpList from './components/EmpList';
import EmailList from './components/EmailList';
import VendorList from './components/VendorList';




function App() {
    return (
        <div>
            <h1>Vendor Management System</h1>
            <EmpForm />
           
            <VendorForm />
            <EmailForm />
            <EmpList />
            <EmailList />
            <VendorList />
           
            
            
          
            
        </div>
    );
}

export default App;
