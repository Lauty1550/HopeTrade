import axios from "axios";

const AYUDANTE_BASE_REST_API_URL = "/ayudante/listar-ayudantes";

class AyudanteService {
  getAllAyudantes() {
    return axios.get(AYUDANTE_BASE_REST_API_URL);
  }
}

export default new AyudanteService();
