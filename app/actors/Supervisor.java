package actors;
import java.time.Duration;
import java.util.Optional;

import akka.actor.AbstractActor;
import akka.actor.OneForOneStrategy;
import akka.actor.Props;
import akka.actor.SupervisorStrategy;
import akka.japi.pf.DeciderBuilder;

public class Supervisor extends AbstractActor {

    // #strategy2
    private static SupervisorStrategy strategy =
        new OneForOneStrategy(
            10,
            Duration.ofMinutes(1),
            DeciderBuilder.match(ArithmeticException.class, e -> SupervisorStrategy.resume())
                .match(NullPointerException.class, e -> SupervisorStrategy.restart())
                .match(IllegalArgumentException.class, e -> SupervisorStrategy.stop())
                .matchAny(o -> SupervisorStrategy.escalate())
                .build());

    @Override
    public SupervisorStrategy supervisorStrategy() {
      return strategy;
    }

    public static Props getProps() {
		return Props.create(Supervisor.class);
	}
    // #strategy2

    @Override
    public Receive createReceive() {
      return receiveBuilder()
          .match(
              Props.class,
              props -> {
                getSender().tell(getContext().actorOf(props, "SearchForRepoActor"),  getSelf());
              })
          .build();
    }

    @Override
    public void preRestart(Throwable cause, Optional<Object> msg) {
      // do not kill all children, which is the default here
    }
  }