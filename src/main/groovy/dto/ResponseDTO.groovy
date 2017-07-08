package dto

class ResponseDTO implements Serializable {
    String message
    Integer id
    boolean status
    Integer code
    def data
    List<ApiErrorDTO> apiErrors = []
}
