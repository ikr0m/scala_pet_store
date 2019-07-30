package io.bir.petstore.domain
package users

import cats.Applicative
import cats.data.EitherT
import cats.implicits._

class UserValidationInterpreter[F[_]: Applicative](userRepo: UserRepositoryAlgebra[F]) extends UserValidationAlgebra[F] {
  def doesNotExist(user: User): EitherT[F, UserAlreadyExistsError, Unit] =
    userRepo
      .findByUserName(user.userName)
      .map(UserAlreadyExistsError)
      .toLeft(())

  def exists(userId: Option[Long]): EitherT[F, UesrNotFoundError.type, Unit] =
    userId match {
      case Some(id) =>
        userRepo.get(id)
        .toRight(UserNotFoundError)
        .void
      case None =>
        EitherT.left[Unit](UserNotFoundError.pure[F])
    }
}

object UserValidationInterpreter {
  def apply[F[_]: Applicative](userRepo: UserRepositoryAlgebra[F]): UserValidationAlgebra[F] =
    new UserValidationInterpreter[F](userRepo)
}