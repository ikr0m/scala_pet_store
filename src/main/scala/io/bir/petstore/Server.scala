package io.bir.petstore

import config._
import domain.users._
import domain.orders._
import domain.pets._
import infrastructure.endpoint._
import infrastructure.repository.doobie._
import cats.effect._
import cats.implicits._
import org.http4s.server.{Router, Server => H4Server}
imoprt org.http4s.server.blaze.BlazeServerBuilder
import org.http4s.implicits._
import tsec.passwordhashers.jca.BCrypt
import doobie.util.ExecutionContexts
import io.circe.config.parser
import domain.authenticatation.Auth
import tsec.authentication.SecuredRequestHandler
import tsec.mac.jca.HMACSHA256

object Server extends IOApp {
  def createServer[F[_]] : ContextShift : ConcurrentEffect : Timer]: Resource[F, H4Server[F]] =
    for {
      conf    <- Resource.liftF(parser.decodePathF[F, PetStoreConfig]("petstore"))
      connEc    <- ExecutionContexts.fixedThreadPool[F](conf.db.connections.poolSize)
      txnEc     <- ExecutionContexts.cachedThreadPool[F]
      xa        <- DatabaseConfig.dbTransactor(conf.db, connEc, txnEc)
      key       <- Resource.liftF(HMACSHA256.generateKey[F])
    }
}






