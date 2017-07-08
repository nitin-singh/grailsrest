package grailsrestapp

import dto.BookDTO
import dto.ResponseDTO
import grails.transaction.Transactional

@Transactional
class BookService {

    ResponseDTO createBook(BookDTO bookDTO) {
        ResponseDTO responseDTO = new ResponseDTO()
        Book book = new Book()
        book.with {
            title = bookDTO.title
            author = bookDTO.author
            genre = bookDTO.genre
            pageCount = bookDTO.pageCount

        }
        book = book.save(flush: true)
        if (book) {
            responseDTO.data = book
            responseDTO.message = "Book created successfully."
            responseDTO.status = true
        } else {
            responseDTO.data = book
            responseDTO.message = "Error Creating Book."
            responseDTO.status = false
        }
        responseDTO
    }

    ResponseDTO fetchBook(Long id) {
        ResponseDTO responseDTO = new ResponseDTO()
        Book book = Book.findById(id)
        if (book) {
            responseDTO.data = book
            responseDTO.status = true
        } else {
            responseDTO.message = "No Book Found"
            responseDTO.status = false
        }
        responseDTO
    }
}
