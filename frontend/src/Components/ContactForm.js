import {Component, useState} from "react";


const ContactForm = () =>{
    const [name, setName] = useState("")
    const [email, setEmail] = useState("")
    const [message, setMessage] = useState("")
    const [showEmail, showNoValidEmail] = useState(true)
    const isValidEmail = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/g;
    const validateEmail = (e) => {
        if(e.target?.value && e.target.value.match(isValidEmail)){
            showNoValidEmail(false);
            setEmail(e.target.value)

        }else{
            showNoValidEmail(true);
        }
    }

    const handleSubmit = (e) => {
        e.preventDefault();
        if(email && email.length && email.match(isValidEmail)){
            setEmail("Thanks for subscribing!");
        }else{

            alert("Enter a valid email");
        }
    };

    return(
        <div className="ContactForm">
            <form className="contact-form" id="contact-form" onSubmit={event => handleSubmit(event)} method="POST">
                <label htmlFor="name">Name</label>
                <input type="text" className="form-control" value={name}
                       onChange={event => setName(event.target.value)}/>
                <label htmlFor="exampleInputEmail1">Email address</label>
                <input type="email" className="form-control" aria-describedby="emailHelp"
                       onChange={event => validateEmail(event)}/>
                <label htmlFor="message">Message</label>
                <textarea className="form-control" rows="5" value={message}
                          onChange={event => setMessage(event.target.value)}/>
                <button type="submit" className="btn btn-primary" >Submit</button>
            </form>
        </div>
    );


}

export default ContactForm