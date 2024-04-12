// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import { getAnalytics } from "firebase/analytics";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
  apiKey: import.meta.env.VITE_APP_FIREBASE_API_KEY,
  authDomain: "taskmanager-4ad8d.firebaseapp.com",
  projectId: "taskmanager-4ad8d",
  storageBucket: "taskmanager-4ad8d.appspot.com",
  messagingSenderId: "19628949810",
  appId: "1:19628949810:web:1510bc89f18be98641172b",
  measurementId: "G-8869860RVJ"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const analytics = getAnalytics(app);