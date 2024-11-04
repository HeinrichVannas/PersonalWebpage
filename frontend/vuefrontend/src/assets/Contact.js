import LinkedIn from "../Images/LinkedIn.png"
import Facebook from "../Images/Facebook_logo.png"
import "../Styles/Contact.css"
import ContactForm from "../Components/ContactForm"

const Contact = () => {
    return (
        <div>
            <h1>Ways to contact me</h1>
            <div className="container">
                <ContactForm/>
                <div className="contacts">
                    <div className="contact">
                        <a href="https://www.linkedin.com/in/heinrich-vannas-b02aa9240" target="_blank"><img src={LinkedIn} alt="LinkedIn icon"/></a>
                        <p>LinkedIn</p>
                    </div>
                    <div className="contact">
                        <a href="https://www.facebook.com/heinrich.vannas" target="_blank"><img src={Facebook} alt="Facebook icon"/></a>
                        <p>Facebook</p>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Contact;