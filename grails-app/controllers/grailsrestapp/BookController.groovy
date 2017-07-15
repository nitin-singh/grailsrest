package grailsrestapp

import dto.ApiErrorDTO
import dto.BookDTO
import dto.ResponseDTO
import enums.ErrorCode

class BookController {

    static responseFormats = ['json']
    static defaultAction = "methodNotAllowed"
    static namespace = "v1"

    BookService bookService

    def create(BookDTO book) {
        bindData(book, request.getJSON())
        respond bookService.createBook(book)
    }

    def fetchBook(Long id) {
        respond bookService.fetchBook(id)
    }

    def methodNotAllowed() {
        respond createErrorResponseDTO(ErrorCode.METHOD_NOT_ALLOWED)
    }

    private static ResponseDTO createErrorResponseDTO(ErrorCode errorCode) {
        new ResponseDTO().with {
            apiErrors.add(
                    new ApiErrorDTO(errorCode: errorCode.code, errorMessage: errorCode.message)
            )
            return it
        }
    }

}
