package exporter.adapter.zeebe;

import io.camunda.zeebe.exporter.api.Exporter;
import io.camunda.zeebe.exporter.api.context.Context;
import io.camunda.zeebe.exporter.api.context.Controller;
import io.camunda.zeebe.protocol.record.Record;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ZeebeAdapter implements Exporter {

    private Controller controller;

    @Override
    public void configure(Context context) throws Exception {
        // no op
    }

    @Override
    public void open(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void close() {
        // no op
    }

    @Override
    public void export(Record<?> record) {
        log.info("Exporting record:\n {}", record.toJson());
        controller.updateLastExportedRecordPosition(record.getPosition());
    }
}
