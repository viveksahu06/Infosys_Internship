// import Carousel from "./Carousel";
// import Footer from "./Footer";
// import { Link } from "react-router-dom";
// import travel_1 from "../images/travel.2.png";
// import travel_2 from "../images/travel.png";

// const HomePage = () => {
//   return (
//     <div className="container-fluid mb-2">
//       <Carousel />

//       <div className="container mt-5">
//         <div className="row">
//           <div className="col-md-8">
//             <h1 className="text-color">
//               Welcome to InfoFlight
//             </h1>
//             <p className="">
             
//             </p>
//             <p>
//               From the moment you step into our digital gateway, you're one step
//               closer to realizing your travel dreams. Join us as we redefine the
//               way you book flights, making every adventure a memorable
//               destination in itself.
//             </p>
//             <Link to="/user/login" className="btn bg-color custom-bg-text">
//               Get Started
//             </Link>
//           </div>
//           <div className="col-md-4">
//             <img
//               src={travel_2}
//               alt="Logo"
//               width="520"
//               height="300"
//               className="home-image rounded"
//             />
//           </div>
//         </div>

//         <div className="row mt-5">
//           <div className="col-md-4">
//             <img
//               src={travel_1}
//               alt="Logo"
//               width="480"
//               height="300"
//               className="home-image rounded mt-2"
//             />
//           </div>
//           <div className="col-md-8">
//             <h1 className="text-color ms-5">
//               Real-time Availability and Instant Confirmation
//             </h1>
//             <p className="ms-5">
//               Experience the ultimate in convenience with our real-time
//               availability and instant confirmation system. Say goodbye to
//               uncertainty and waiting – our cutting-edge technology ensures you
//               receive up-to-the-minute flight availability and confirmation,
//               giving you the confidence to secure your travel plans without
//               delay. With just a few clicks, you can explore flight options,
//               select your preferred class, and receive immediate confirmation,
//               putting you on the fast track to your next adventure.
//             </p>
//             <p className="ms-5">
//               Moreover, our system offers instant confirmation of bookings. Once
//               users complete their reservation, they receive an immediate
//               confirmation email or notification, assuring them that their
//               tickets are secured and ready for travel. This eliminates any
//               uncertainty and allows customers to proceed with their travel
//               plans with confidence.
//             </p>
//             <Link to="/user/login" className="btn bg-color custom-bg-text ms-5">
//               Get Started
//             </Link>
//           </div>
//         </div>
//       </div>
//       <hr />
//       <Footer />
//     </div>
//   );
// };

// export default HomePage; 
import Carousel from "./Carousel";
import Footer from "./Footer";
import { Link } from "react-router-dom";
import travel_1 from "../images/travel.2.png";
import travel_2 from "../images/travel.png";
import "../style.css"

const HomePage = () => {
   // Split the welcome text into individual characters
   const welcomeText = "Welcome to InfoFlight";
   const welcomeArray = welcomeText.split("");
  return (
    <div className="container-fluid mb-2">
      <Carousel />

      <div className="container mt-5">
        <div className="row">
          <div className="col-md-8">
            <h1 className="text-color animated-text">
              {welcomeArray.map((char, index) => (
                <span key={index}>{char}</span>
              ))}
            </h1>
            <p>
              Adventure awaits at InfoFlight! Step into a world where travel dreams take flight. Our innovative platform redefines the booking experience, transforming each journey into a story waiting to be told. Start your adventure with us today and make every moment count.
            </p>
            <Link to="/user/login" className="btn bg-color custom-bg-text">
              Get Started
            </Link>
          </div>
          <div className="col-md-4">
            <img
              src={travel_2}
              alt="Scenic Travel"
              width="520"
              height="300"
              className="home-image rounded"
            />
          </div>
        </div>

        <div className="row mt-5">
          <div className="col-md-4">
            <img
              src={travel_1}
              alt="Travel Booking"
              width="480"
              height="300"
              className="home-image rounded mt-2"
            />
          </div>
          <div className="col-md-8">
            <h1 className="text-color ms-5">
              Real-time Availability and Instant Confirmation
            </h1>
            <p className="ms-5">
              Discover the pinnacle of convenience with InfoFlight. Our real-time availability and instant confirmation system eradicates uncertainty, ensuring you receive the latest flight details and secure your plans without delay. Explore, select, and confirm your next adventure in just a few clicks.
            </p>
            <p className="ms-5">
              With InfoFlight, booking is seamless. The moment you finalize your reservation, instant confirmation is delivered to your inbox, solidifying your travel plans. This swift and efficient process empowers you to focus on the excitement of your upcoming journey.
            </p>
            <Link to="/user/login" className="btn bg-color custom-bg-text ms-5">
              Get Started
            </Link>
          </div>
        </div>
      </div>
      <hr />
      <Footer />
    </div>
  );
};

export default HomePage;

