import { Link } from "react-router-dom";
import {
  FaTachometerAlt,
  FaUsers,
  FaTasks,
  FaCalendarCheck,
  FaCertificate,
} from "react-icons/fa";

function Sidebar() {
  return (
    <div className="sidebar">
      <h2>IMS</h2>

      <ul>
        <li>
          <Link to="/">
            <FaTachometerAlt /> Dashboard
          </Link>
        </li>

        <li>
          <Link to="/interns">
            <FaUsers /> Interns
          </Link>
        </li>

        <li>
          <Link to="/tasks">
            <FaTasks /> Tasks
          </Link>
        </li>

        <li>
          <Link to="/attendance">
            <FaCalendarCheck /> Attendance
          </Link>
        </li>

        <li>
          <Link to="/certificates">
            <FaCertificate /> Certificates
          </Link>
        </li>
      </ul>
    </div>
  );
}

export default Sidebar;