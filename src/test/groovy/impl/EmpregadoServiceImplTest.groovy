package impl

import com.relacionamento.table.model.Departamento
import com.relacionamento.table.model.Empregado
import com.relacionamento.table.repository.EmpregadoRepository
import com.relacionamento.table.service.impl.EmpregadoServiceImpl
import spock.lang.Specification

class EmpregadoServiceImplTest extends Specification {

    def repository = Mock(EmpregadoRepository)
    def service = new EmpregadoServiceImpl(repository)

    def departamento = Departamento.builder().id(1L).nome("RH").build()

    def "deve listar os empregados"() {
        given:
        def empregados = [Empregado.builder().id(1L).nome("Daniel").salario("3900").departamento(departamento).build()]

        when:
        def result = service.findAll()

        then:
        1 * repository.findAll() >> empregados
        0 * _
        result == empregados
    }

    def "deve criar empregado"() {
        given:
        def request = Empregado.builder().nome("Daniel").salario("3900").departamento(departamento).build()
        def empregadoSave = Empregado.builder().id(1L).nome("Daniel").salario("3900").departamento(departamento).build()

        when:
        def result = service.create(request)

        then:
        1 * repository.save(request) >> empregadoSave
        0 * _
        empregadoSave == result
    }
}
