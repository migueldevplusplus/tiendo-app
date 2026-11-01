import { Routes, Route } from "react-router"
import StorePage from "./pages/StorePage.tsx"

function App() {
  return (
    <Routes>
      <Route path="/:slug" element={<StorePage />}></Route>
    </Routes>
  );
}

export default App
